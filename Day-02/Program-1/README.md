During university examinations, students are issued printed hall tickets.

Due to a printing issue, some hall tickets may accidentally be scanned upside down in the exam verification system.

The scanning system automatically interprets the hall ticket number after flipping it 180 degrees.

However, only certain digits remain valid after flipping:

0 remains 0

1 remains 1

8 remains 8

6 becomes 9

9 becomes 6

All other digits become invalid when flipped.

A hall ticket number is considered Reversible if:

Every digit remains valid after flipping, and

The flipped number matches the original number exactly.

Your task is to determine whether a given hall ticket number is Reversible.

INPUT FORMAT:

Line-1: A numeric string representing hall ticket number.

OUTPUT FORMAT:

Print true if the hall ticket number is Reversible.
Otherwise print false.

SAMPLE INPUT-1:

69

SAMPLE OUTPUT-1:

true

Explanation:
69 becomes 96 after flipping, and when reversed positionally it matches 69.

SAMPLE INPUT-2:

962

SAMPLE OUTPUT-2:

false

Explanation:
Digit 2 becomes invalid when flipped.
