A college professor is forming special study groups for an advanced coding 
workshop.

Each student has scored certain marks in a recent test. The marks are stored
in an array.

The professor wants to select exactly K consecutive students to form a study
group.

However, there is one strict condition:

All students in the selected group must have different marks.

Your task is to determine the maximum total marks of any such valid study group.

If no valid group exists, return 0.

INPUT FORMAT:

Line-1: Two space separated integers N and K.
Line-2: N space separated integers representing marks[].

OUTPUT FORMAT:

Print an integer result.

SAMPLE INPUT-1:

7 3
5 2 3 5 4 2 1

SAMPLE OUTPUT-1:

12

Explanation:
The subarrays of size 3 are:

[5,2,3] → valid → sum = 10

[2,3,5] → valid → sum = 10

[3,5,4] → valid → sum = 12

[5,4,2] → valid → sum = 11

[4,2,1] → valid → sum = 7

Return 12 because it is the maximum valid sum.

SAMPLE INPUT-2:

4 2
1 1 1 1

SAMPLE OUTPUT-2:

0

Explanation:
All groups contain duplicate marks.

