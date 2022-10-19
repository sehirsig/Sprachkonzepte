// AMPM.g4
lexer grammar AMPM;
                    
Number: ((Hours)(Seperator)(Minutes)(USformat)) | ('12:00 'Fullformat);


fragment Hours: ([1][0-2])|([1-9]);
fragment Minutes: ([0-5][0-9]);
fragment USformat: ' a.m' | ' p.m' ;
fragment Fullformat: 'noon'|'midnight';
fragment Seperator: ':';

PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';

WS: [ \t\r\n]+ -> channel(HIDDEN);

