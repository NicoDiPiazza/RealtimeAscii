# RealtimeAscii
A realtime Ascii renderer written in the Java language

How it operates:
Every frame, it takes a screenshot.
Then, it isolates the right half of the screenshot.
Then, it creates an ascii render of that half of the screenshot
Lastly, it prints that render to the command line.

Reccomended use:
I recommend pulling up the command line on the left half of your screen, setting whatever you want translated to ascii on the right half (I find that a live camera feed is pretty fun. I did this by setting up a zoom meeting of only me.) Once you have both pulled up, compiling the program and running it should produce the render in the command line. The program then runs indefinitely, I recommend using crtl + c to stop it.
