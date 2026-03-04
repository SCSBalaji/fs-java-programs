A secure communication system sends encrypted data using layered encoding.

Each message consists of nested secure layers represented using square 
brackets [ ].

A secure layer:

Starts with [

Ends with ]

May contain other secure layers inside it

Multiple secure layers can appear one after another in the transmission.

For security auditing, the outermost encryption layer of every independent 
secure block must be removed.

Your task is to process the transmission and return the message after stripping
the outermost layer from each independent secure block.

INPUT FORMAT:

Line-1: A string S consisting only of '[' and ']'.
It is guaranteed that S is a valid secure transmission.

OUTPUT FORMAT:

Print the filtered transmission after removing the outermost layer from each 
independent secure block.

SAMPLE INPUT-1:

[[]][[][]][]

SAMPLE OUTPUT-1:

[][][]

SAMPLE INPUT-2:

[[][]][[]][[][[]]]

SAMPLE OUTPUT-2:

[][][][][[]]
