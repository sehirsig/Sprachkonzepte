// AMPM.g4
lexer grammar AMPM;
                    
Number: ([0-1])|('12:00 ' ('noon'|'midnight'));

// (FirstDigit SecondDigit (':' FirstDigit SecondDigit)? (('a.'|'p.')(' ')?'m.'))


fragment FirstDigit: ([0-1]);
fragment SecondDigit: ([0-9]);

PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';

WS: [ \t\r\n]+ -> channel(HIDDEN);

