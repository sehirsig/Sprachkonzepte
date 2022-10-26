// Lexer Grammar = Vokabeln
lexer grammar OURLexer;

//{hallo}%[123]%{bye%}€
STRING      :   '{' TEXT+ '}' ;
NUMBERS     :   '[' DIGIT+ ']';


TEXT        :   [a-zA-Z]    ;
DIGIT       :   [0-9]       ;
SEPERATOR   :   '%'         ;
EOL         :   '€'         ;


WS: [ \t\r\n]+ -> channel(HIDDEN);