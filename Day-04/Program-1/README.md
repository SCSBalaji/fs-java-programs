A secure communication system generates valid encryption strings using a 
fixed block pattern "pqr".

The system starts with an empty string and repeatedly inserts the block
"pqr" at any position.

You are given a string S consisting only of characters 'p', 'q', and 'r'.
Determine whether the given string could have been formed only by repeatedly
inserting "pqr" any number of times.

Input Format:
A single string S.

Output Format:
Print true if valid. Print false otherwise.

Sample Input 1:
ppqrrpqr
Sample Output 1:
false

Sample Input 2:
pqrpqrpqrr
Sample Output 2:
false

Sample Input 3:
pqrprq
Sample Output 3:
false

Sample Input 4:
pqrpqr
Sample Output 4:
true

Sample Input 5:
ppqrqrpqpqrr
Sample Output 5:
true
