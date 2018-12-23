"#" 

from maze_follower import test, step

def test_test():
    result = test()
    assert(result == 100)

def test_given_i_have_received_a_board_that_is_missing_a_start_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["E"]
    try:
        result, x, y = step(maze, -1, -1)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_board_that_is_missing_an_end_position_when_evaluating_then_an_exception_is_thrown():
    maze = ["S"]
    try:
        result, x, y = step(maze, -1, -1)
        assert(False)
    except ValueError:
        return

def test_given_i_have_received_a_valid_board_when_stepping_then_no_error_is_thrown():
    maze = ["SE"]
    result, x, y = step(maze, -1, -1)
    assert(True)

def test_given_i_have_received_a_valid_board_with_multiple_lines_when_stepping_then_no_error_is_thrown():
    maze = ["S","E"]
    result, x, y = step(maze, -1, -1)
    assert(True)

def test_given_an_unnavigated_board_when_stepping_then_the_start_position_is_returned():
    maze = [
        "WS",
        "WE"
    ]
    result, x, y = step(maze, -1, -1)
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
