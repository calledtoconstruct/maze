
def validate(maze):
    start = 0
    end = 0
    for line in maze:
        if "S" in line:
            start = start + 1
        if "E" in line:
            end = end + 1
    if start == 0 or end == 0:
        raise ValueError()

def start(maze):
    for y, line in enumerate(maze):
        for x, current in enumerate(line):
            if current == 'S':
                return current, x, y, []

def step(maze, cx = -1, cy = -1):
    if cx == -1 or cy == -1:
        validate(maze)
        return start(maze)
    options = []
    for y, line in enumerate(maze):
        for x, current in enumerate(line):
            if (cx == x and y in [cy-1, cy+1]) or (cy == y and x in [cx-1, cx+1]):
                if current == 'E':
                    return "Victory!", x, y, []
                if current == ' ':
                    options.append((x, y))
    if len(options) > 0:
        x, y = options.pop(0)
        maze[cy] = maze[cy][0:cx] + '*' + maze[cy][cx+1:]
        maze[y] = maze[y][0:x] + 'C' + maze[y][x+1:]
        return ' ', x, y, options
    return 'D', 0, 0, []

def traverse(maze, step):
    count = 0
    result, x, y, options = step(maze)
    while result != "Victory!":
        result, x, y, options = step(maze, x, y)
        count = count + 1
        if result == 'D':
            break
    return result, count