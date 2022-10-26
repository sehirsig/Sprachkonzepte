parser grammar OURParser;

options { tokenVocab=OURLexer; }

satz    :   (STRING | NUMBERS) (addsatz)* EOL  ;

addsatz :   (SEPERATOR (STRING | NUMBERS))  ;

// {Test}%[42]%[4332]€