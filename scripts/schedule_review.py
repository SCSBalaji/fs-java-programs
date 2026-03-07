import os
import json
from datetime import datetime, timedelta

REVIEW_INTERVALS = [1, 3, 7, 14, 30, 60]  # Days for spaced repetition

def load_review_data():
    """Load review schedule data."""
    if os.path.exists('stats/reviews.json'):
        with open('stats/reviews.json', 'r') as f:
            return json.load(f)
    return {}

def save_review_data(data):
    """Save review schedule data."""
    os.makedirs('stats', exist_ok=True)
    with open('stats/reviews.json', 'w') as f:
        json.dump(data, f, indent=2)

def get_all_programs():
    """
    Scan repo and return all Day-XX/Program-Y entries.
    Returns list of dicts: { 'key', 'day', 'program', 'path' }
    """
    programs = []

    for entry in sorted(os.listdir('.')):
        # Match folders like Day-01, Day-02, Day-10, etc.
        if not os.path.isdir(entry):
            continue
        if not entry.lower().startswith('day-'):
            continue

        day_path = entry
        day_num = entry.split('-')[1]  # e.g. "01", "02"

        for sub in sorted(os.listdir(day_path)):
            sub_path = os.path.join(day_path, sub)

            # Match folders like Program-1, Program-2, Program-10, etc.
            if not os.path.isdir(sub_path):
                continue
            if not sub.lower().startswith('program-'):
                continue

            prog_num = sub.split('-')[1]  # e.g. "1", "2"
            key = f"Day-{day_num}/Program-{prog_num}"

            programs.append({
                'key': key,
                'day': int(day_num),
                'program': int(prog_num),
                'path': sub_path
            })

    return programs

def find_program(day, program):
    """
    Find a specific Day-XX/Program-Y folder.
    Returns (path, key) or (None, None).
    """
    day_str = str(day).zfill(2)   # e.g. 1 -> "01"
    prog_str = str(program)        # e.g. 1 -> "1"

    day_folder = f"Day-{day_str}"
    prog_folder = f"Program-{prog_str}"

    if not os.path.isdir(day_folder):
        # Try without zero-padding too (Day-1 fallback)
        day_folder_alt = f"Day-{day}"
        if os.path.isdir(day_folder_alt):
            day_folder = day_folder_alt
        else:
            return None, None

    prog_path = os.path.join(day_folder, prog_folder)
    if not os.path.isdir(prog_path):
        return None, None

    key = f"{day_folder}/{prog_folder}"
    return prog_path, key

def get_solution_count(program_path):
    """Count the number of .java solution files in a program folder."""
    if not os.path.exists(program_path):
        return 0
    return sum(1 for f in os.listdir(program_path) if f.endswith('.java'))

def get_program_title(program_path):
    """Extract problem title from the program's README.md if available."""
    readme_path = os.path.join(program_path, 'README.md')
    if os.path.exists(readme_path):
        with open(readme_path, 'r', encoding='utf-8') as f:
            for line in f:
                line = line.strip()
                if line.startswith('#'):
                    # Return first heading found
                    return line.lstrip('#').strip()
    return None

def mark_reviewed(day, program):
    """Mark a Day/Program as reviewed and schedule next review."""
    data = load_review_data()

    program_path, key = find_program(day, program)

    if not program_path:
        day_str = str(day).zfill(2)
        print(f"❌ Day-{day_str}/Program-{program} not found!")
        print(f"   Make sure the folder 'Day-{day_str}/Program-{program}' exists in the repo root.")
        return

    title = get_program_title(program_path) or f"Day {day} - Program {program}"
    solution_count = get_solution_count(program_path)

    if key not in data:
        data[key] = {
            'title': title,
            'path': program_path,
            'solution_count': solution_count,
            'review_count': 0,
            'last_reviewed': None,
            'next_review': None
        }

    review_count = data[key]['review_count']
    today = datetime.now().strftime('%Y-%m-%d')

    # Spaced repetition: pick interval
    if review_count < len(REVIEW_INTERVALS):
        days_until_next = REVIEW_INTERVALS[review_count]
    else:
        days_until_next = 90  # Every 3 months after full mastery

    next_review = (datetime.now() + timedelta(days=days_until_next)).strftime('%Y-%m-%d')

    # Update record
    data[key]['review_count'] = review_count + 1
    data[key]['last_reviewed'] = today
    data[key]['next_review'] = next_review
    data[key]['title'] = title
    data[key]['solution_count'] = solution_count
    data[key]['path'] = program_path

    save_review_data(data)

    print(f"✅ Marked {key} as reviewed")
    print(f"📝 Title          : {title}")
    print(f"💡 Solutions      : {solution_count} .java file(s)")
    print(f"📅 Next review    : {next_review} (+{days_until_next} days)")
    print(f"🔢 Review count   : {review_count + 1}")

def show_due_reviews():
    """Show programs that need review today (and overdue ones)."""
    data = load_review_data()
    today = datetime.now().strftime('%Y-%m-%d')

    due = []
    overdue = []

    for key, info in data.items():
        if not info.get('next_review'):
            continue
        entry = {
            'key': key,
            'title': info.get('title', key),
            'next_review': info['next_review'],
            'review_count': info['review_count'],
            'solution_count': info.get('solution_count', 0)
        }
        if info['next_review'] == today:
            due.append(entry)
        elif info['next_review'] < today:
            overdue.append(entry)

    if not due and not overdue:
        print("🎉 No programs due for review today!")
        return

    if overdue:
        overdue.sort(key=lambda x: x['next_review'])
        print(f"⚠️  {len(overdue)} OVERDUE program(s):\n")
        for p in overdue:
            print(f"  {p['key']}")
            print(f"    📝 {p['title']}")
            print(f"    Review #{p['review_count'] + 1} | Was due: {p['next_review']} | Solutions: {p['solution_count']}")
            print()

    if due:
        due.sort(key=lambda x: x['key'])
        print(f"📚 {len(due)} program(s) due for review today:\n")
        for p in due:
            print(f"  {p['key']}")
            print(f"    📝 {p['title']}")
            print(f"    Review #{p['review_count'] + 1} | Due: {p['next_review']} | Solutions: {p['solution_count']}")
            print()

def show_schedule():
    """Show upcoming review schedule grouped by date."""
    data = load_review_data()

    if not data:
        print("No programs scheduled for review yet.")
        print("Use: python scripts/schedule_review.py mark <day> <program>")
        return

    upcoming = []
    for key, info in data.items():
        if info.get('next_review'):
            upcoming.append({
                'key': key,
                'title': info.get('title', key),
                'date': info['next_review'],
                'count': info['review_count'],
                'solution_count': info.get('solution_count', 0)
            })

    upcoming.sort(key=lambda x: (x['date'], x['key']))
    today = datetime.now().strftime('%Y-%m-%d')

    print("📅 Upcoming Reviews:\n")

    current_date = None
    shown = 0

    for item in upcoming[:20]:
        if item['date'] != current_date:
            label = ''
            if item['date'] < today:
                label = '  ⚠️  OVERDUE'
            elif item['date'] == today:
                label = '  ← Today'
            print(f"\n{item['date']}{label}:")
            current_date = item['date']

        print(f"  • {item['key']} — {item['title']}")
        print(f"    Review #{item['count'] + 1} | {item['solution_count']} solution(s)")
        shown += 1

    remaining = len(upcoming) - shown
    if remaining > 0:
        print(f"\n  ... and {remaining} more program(s).")

def show_all_programs():
    """List all Day/Program folders found in the repo."""
    programs = get_all_programs()
    data = load_review_data()

    if not programs:
        print("No Day-XX/Program-Y folders found in the repo root.")
        return

    print(f"📁 All Programs in Repo ({len(programs)} total):\n")

    current_day = None
    for p in programs:
        day_label = f"Day-{str(p['day']).zfill(2)}"
        if day_label != current_day:
            print(f"\n  {day_label}:")
            current_day = day_label

        key = p['key']
        reviewed = key in data
        review_count = data[key]['review_count'] if reviewed else 0
        next_review = data[key].get('next_review', '—') if reviewed else '—'
        solutions = get_solution_count(p['path'])

        status = f"✅ Reviewed {review_count}x | Next: {next_review}" if reviewed else "🆕 Never reviewed"
        print(f"    Program-{p['program']}  |  {solutions} solution(s)  |  {status}")

def show_stats():
    """Show overall review statistics."""
    data = load_review_data()
    all_programs = get_all_programs()
    today = datetime.now().strftime('%Y-%m-%d')

    total_in_repo = len(all_programs)
    total_tracked = len(data)
    not_started = total_in_repo - total_tracked
    due_today = sum(1 for i in data.values() if i.get('next_review') == today)
    overdue = sum(1 for i in data.values() if i.get('next_review') and i['next_review'] < today)
    mastered = sum(1 for i in data.values() if i.get('review_count', 0) >= len(REVIEW_INTERVALS))

    # Per-day breakdown
    day_stats = {}
    for p in all_programs:
        day_label = f"Day-{str(p['day']).zfill(2)}"
        if day_label not in day_stats:
            day_stats[day_label] = {'total': 0, 'reviewed': 0}
        day_stats[day_label]['total'] += 1
        if p['key'] in data:
            day_stats[day_label]['reviewed'] += 1

    print("📊 Review Statistics\n")
    print(f"  Total programs in repo : {total_in_repo}")
    print(f"  Tracked (reviewed ≥1x) : {total_tracked}")
    print(f"  Never reviewed         : {not_started}")
    print(f"  Due today              : {due_today}")
    print(f"  Overdue                : {overdue}")
    print(f"  Mastered (≥{len(REVIEW_INTERVALS)} reviews)  : {mastered}")
    print()
    print("  Per-Day Progress:")
    for day_label in sorted(day_stats.keys()):
        s = day_stats[day_label]
        bar_filled = s['reviewed']
        bar_empty = s['total'] - s['reviewed']
        bar = '█' * bar_filled + '░' * bar_empty
        print(f"    {day_label}  [{bar}]  {s['reviewed']}/{s['total']} reviewed")

if __name__ == "__main__":
    import sys

    # Always run from repo root regardless of where script is invoked
    script_dir = os.path.dirname(os.path.abspath(__file__))
    repo_root = os.path.dirname(script_dir)
    os.chdir(repo_root)

    def print_help():
        print("Usage: python scripts/schedule_review.py <command> [args]")
        print()
        print("Commands:")
        print("  due                      - Show programs due today + overdue")
        print("  schedule                 - Show upcoming review schedule")
        print("  mark <day> <program>     - Mark a Day/Program as reviewed")
        print("  list                     - List all programs with review status")
        print("  stats                    - Show review statistics")
        print()
        print("Examples:")
        print("  python scripts/schedule_review.py mark 1 1    -> Day-01/Program-1")
        print("  python scripts/schedule_review.py mark 2 3    -> Day-02/Program-3")
        print("  python scripts/schedule_review.py mark 5 2    -> Day-05/Program-2")
        print("  python scripts/schedule_review.py due")
        print("  python scripts/schedule_review.py list")
        print("  python scripts/schedule_review.py stats")

    if len(sys.argv) < 2:
        print_help()
        sys.exit(1)

    command = sys.argv[1]

    if command == "due":
        show_due_reviews()
    elif command == "schedule":
        show_schedule()
    elif command == "list":
        show_all_programs()
    elif command == "stats":
        show_stats()
    elif command == "mark":
        if len(sys.argv) < 4:
            print("❌ Usage: python scripts/schedule_review.py mark <day> <program>")
            print("   Example: python scripts/schedule_review.py mark 2 3")
            sys.exit(1)
        mark_reviewed(sys.argv[2], sys.argv[3])
    else:
        print(f"❌ Unknown command: '{command}'")
        print()
        print_help()
        sys.exit(1)