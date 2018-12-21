"#" 

def test():
    return 100

def step(maze):
    if "S" not in maze:
        raise ValueError()
    if "E" not in maze:
        raise ValueError()
    return
