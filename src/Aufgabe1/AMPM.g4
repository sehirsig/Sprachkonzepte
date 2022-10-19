// AMPM.g4
grammar AMPM;

Time: (Hours Seperator Minutes USformat)|Fullformat;

// (FirstDigit SecondDigit (':' FirstDigit SecondDigit)? (('a.'|'p.')('     ')?'m.'))
// input: 12:00 a.m.

fragment Hours: ('1'[0-2])|[1-9];
fragment Minutes: [0-5][0-9]' ';
fragment USformat: AM|PM;
fragment Fullformat: '12:00 '(NOON|MIDNIGHT);

Seperator: ':';
AM: 'a.m.';
PM: 'p.m.';
NOON: 'noon';
MIDNIGHT: 'midnight';

WS: [ \t\r\n]+ -> channel(HIDDEN);

main: Time;