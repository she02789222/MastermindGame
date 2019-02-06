# MastermindGame
Mastermind is a board game. The first player invents a code consisting of 4 balls of six different colors and the second player tries to break it. For the task simplicity, we'll use capital letters from A to F instead of colors. Note that the letters might be repeated in the code.

The second player makes consecutive attempts to guess the code: he suggests the new combination of letters on each try until his guess is correct. The first player evaluates each combination by comparing it to her secret and says how many letters are guessed correctly.

First, she says the number of letters which are guessed right with their positions. Then she compares the remaining letters and says how many of them are guessed properly: the letters are present both in the guess and in the secret, but stay not in their correct positions. If there are duplicate letters in the guess, they all are counted as "wrongPosition" letters if they correspond to the same number of duplicated letters in the hidden code.

Your task is to evaluate a guess in comparison to a given secret code.

## Different Letters

### Example 1

Secret ABCD and guess ABCD must be evaluated to: rightPosition = 4, wrongPosition = 0. All letters are guessed correctly in respect to their positions.

### Example 2

Secret ABCD and guess CDBA must be evaluated to: rightPosition = 0, wrongPosition = 4. All letters are guessed correctly, but none has the right position.

### Example 3

Secret ABCD and guess ABDC must be evaluated to: rightPosition = 2, wrongPosition = 2. A and B letters and their positions are guessed correctly. C and D letters are guessed correctly, but their positions are wrong.

## Repeated Letters

### Example 4

Secret AABC and guess ADFE must be evaluated to: rightPosition = 1, wrongPosition = 0. A at the first position is guessed correctly with its position. If we remove the first A from consideration (comparing the remaining ABC and DFE only), that will give us no more common letters or positions.

### Example 5

Secret AABC and guess DEAA must be evaluated to: rightPosition = 0, wrongPosition = 2. No letters are guessed correctly concerning their positions. When we compare the letters without positions, A is guessed correctly. Since A is present twice in both guess and secret, it must be counted two times.
