"#" 

from maze_follower import test, step, traverse

def test_test():
    result = test()
    assert(result == 100)

def test_given_i_have_received_a_board_that_is_missing_a_start_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["E"]
    try:
        result, x, y = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_board_that_is_missing_an_end_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["S"]
    try:
        result, x, y = step(maze)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_valid_board_when_stepping_then_no_error_is_thrown():
    maze = ["SE"]
    result, x, y = step(maze)
    assert(True)

def test_given_i_have_received_a_valid_board_with_multiple_lines_when_stepping_then_no_error_is_thrown():
    maze = ["S","E"]
    result, x, y = step(maze)
    assert(True)

def test_given_an_unnavigated_board_when_stepping_then_the_start_position_is_returned():
    maze = [
        "WS",
        "WE"
    ]
    result, x, y = step(maze)
    assert(result == "S")
    assert(x == 1)
    assert(y == 0)

def test_given_i_am_at_a_known_location_when_stepping_then_the_position_of_the_empty_space_is_returned():
    maze = [
        "WS",
        "W E"
    ]
    result, x, y = step(maze, 1, 0)
    assert(result == " ")
    assert(x == 1)
    assert(y == 1)

def test_given_i_am_at_a_known_location_when_stepping_then_an_error_is_raised():
    maze = [
        "WSW",
        "WWE"
    ]
    try:
        result, x, y = step(maze, 1, 0)
        assert(False)
    except ValueError:
        return

def test_given_i_am_at_a_known_location_when_stepping_then_the_location_i_move_from_is_filled_with_a_breadcrum():
    maze = [
        "WSW",
        "W E"
    ]
    result, x, y = step(maze, 1, 0)
    assert(maze[0][1] == '*')
    maze = [
        "WS W",
        "WWE"
    ]
    result, x, y = step(maze, 1, 0)
    assert(maze[0][1] == '*')

def test_given_i_am_at_a_known_location_when_stepping_then_the_location_i_move_to_is_filled_with_a_current_position_marker():
    maze = [
        "WSW",
        "W E"
    ]
    result, x, y = step(maze, 1, 0)
    assert(maze[y][x] == 'C')

def test_given_i_am_at_a_known_location_and_the_endpoint_is_adjacent_when_stepping_then_victory_and_the_position_of_the_endpoint_is_returned():
    maze = [
        "W*W",
        "WCE"
    ]
    result, x, y = step(maze, 1, 1)
    assert(result == "Victory!")
    assert(x == 2)
    assert(y == 1)

def test_given_a_valid_maze_when_enumerating_each_step_then_victory_is_achieved():
    maze = [
        "WWWWWWWWWWWW",
        "WS         W",
        "WWWWWWWWWW W",
        "W          W",
        "WEWWWWWWWWWW",
        "WWW"
    ]
    result, breadcrums = traverse(maze)
    assert(result == "Victory!")
    assert(breadcrums == 21)
