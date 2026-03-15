A sports analyst is studying the momentum of a long cricket match.
For every over, the analyst records the team's performance as:

0 → Defensive over
1 → Aggressive scoring over

The analyst wants to identify the longest continuous period of overs
where the number of defensive overs and aggressive overs are exactly equal.

Such a balanced period helps analysts understand moments where the
team maintained equilibrium between attack and defense.

Your task is to determine the length of the longest contiguous sequence
of overs where the number of 0s and 1s are equal.

If no such balanced sequence exists, print 0.

Input Format:
-------------

First line contains an integer N representing the number of overs recorded.

Second line contains N space-separated integers representing the match pattern.
Each value will be either 0 or 1.

Output Format:
--------------

Print a single integer representing the length of the longest balanced segment.

Sample Input-1:
---------------

2
0 1

Sample Output-1:
----------------

2

Explanation:
------------

The sequence [0,1] has one defensive and one aggressive over,
so the longest balanced segment length is 2.


Sample Input-2:
---------------

6
0 1 0 0 1 1

Sample Output-2:
----------------
6
