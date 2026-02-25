AI Log Monitoring System – Duplicate Alert

A cybersecurity firm is developing an AI-powered intrusion detection system.

The system receives a sequence of login request IDs from different devices.
Each request ID is represented as an integer.

Due to potential cyber attacks, the system must immediately detect if any request ID appears more than once.

If any login request ID is repeated, it may indicate a replay attack or suspicious activity.

Your task is to help the AI system determine whether any duplicate request ID exists in the given sequence.

INPUT FORMAT:
Line-1: An integer N, representing number of login requests.
Line-2: N space separated integers representing requestIDs[].

OUTPUT FORMAT:
Print true if duplicate request ID exists.
Otherwise print false.

case =1
input =5
101 205 333 101 890
output =true

case =2
input =4
11 22 33 44
output =false

case =3
input =6
1 2 3 4 5 6
output =false

case =4
input =6
10 20 30 40 50 10
output =true

case =5
input =1
99
output =false

case =6
input =8
5 3 8 6 2 7 3 9
output =true

case =7
input =10
1000 2000 3000 4000 5000 6000 7000 8000 9000 10000
output =false

case =8
input =7
12 15 18 21 24 27 15
output =true
