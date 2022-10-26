// AMPM.g4
grammar AMPM;


Hours: ([1][0-2])|([1-9]);
Minutes: ([0-5][0-9]);
USformat: ' a.m' | ' p.m' ;
Fullformat: 'noon'|'midnight';
Seperator: ':';
main: (Hours Seperator Minutes USformat) | ('12:00 'Fullformat); // rechtslick test rule main




PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';

WS: [ \t\r\n]+ -> channel(HIDDEN);

