# maze runner
A variety of implementations of an application that can walk thru a maze defined by the following:

W - indicates a wall or obstruction
S - indicates the one and only start position
E - indicates the one and only end position
[space] - indicates a pathway
* - indicates a breadcrumb left behind after the runner passes thru
C - indicates the current location of the runner

Example:

    "WWWWWWWWWWW",
    "WS    W   W",
    "WWWWW W W W",
    "W   W   W W",
    "W W W WWW W",
    "W W W WWW W",
    "W W WWWWW W",
    "W W     W W",
    "WEWWWWW   W",
    "WWWWWWWWWWW"

The above example uses a dead-end which is only supported in some of the implementations.
