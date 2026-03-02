
Warehouse Multiplication Index System

A logistics company maintains a list of package weight multipliers stored in an array.

For performance analysis, the system needs to calculate a special metric for each package:

For each position i, compute the multiplication of all package weights except the package at position i.

Important constraints:

You are not allowed to use division.

The solution must run efficiently.

Help the warehouse system compute this special multiplication index.

INPUT FORMAT:

Line-1: An integer N, number of packages.
Line-2: N space separated integers representing weights[].

OUTPUT FORMAT:

Print the resulting array.

case =1
input =4
1 2 3 4
output =[24, 12, 8, 6]

case =2
input =5
2 3 4 5 6
output =[360, 240, 180, 144, 120]

case =3
input =3
3 5 2
output =[10, 6, 15]

case =4
input =4
1 1 1 1
output =[1, 1, 1, 1]

case =5
input =4
5 0 2 3
output =[0, 30, 0, 0]

case =6
input =2
10 20
output =[20, 10]

case =7
input =1
7
output =[1]

case =8
input =5
1 2 0 4 5
output =[0, 0, 40, 0, 0]