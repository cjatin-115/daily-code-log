it's the second day . i asked chat gpt to generate me the second day task and it suggested me :

  create a number guessing game  with 
    - The program randomly selects a number between 1 and 100.

    - The user tries to guess the number.

    - After each guess, the program tells the user if the guess is too high, too low, or correct.

    - Limit the user to a max of 5 or 7 attempts.


i'm thinking of it's logic like : 
  first i write all the basic 
  then declare 3 variables (RandomNum ,UserInput ,Attempts )( initialy = 0)
  the machine choosed 1 number for the RandomNum 
  the user inputs a number which will be stored in UserInput
  then i create a loop that runs max 6 time 
  in loop if the UserInput == RandomNum then print correct guess !!
  elif the UserInput>RandomNum print too high
  else  print too low

  then loop closes and we check one last time if the UserInput == RandomNum then print correct guess !!
  else print You've used all 7 attempts. The number was 42. Better luck next time!
