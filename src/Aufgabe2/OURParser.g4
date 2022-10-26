parser grammar OURParser;

options { tokenVocab=OURLexer; }

satz    :   (STRING | NUMBERS) (addsatz)* EOL  ;

addsatz :   (SEPERATOR (STRING | NUMBERS))  ;

// {Test}%[42]%[4332]€  -> RICHTIG
// [9124]%{324}€       -> FALSCH
// {BRAND}%[050]%[233]%{Brot}€  -> RICHTIG