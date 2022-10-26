parser grammar OURParser;

options { tokenVocab=OURLexer; }

start: sentence EOF;

sentence    :   (value (multSentence | EOL))  ;

multSentence :   (SEPERATOR value multSentence) | (SEPERATOR value EOL) ;

value   :   (STRING | NUMBERS)  ;

// {Test}%[42]%[4332]€  -> RICHTIG
// [9124]%{324}€       -> FALSCH
// {BRAND}%[050]%[233]%{Brot}.  -> RICHTIG