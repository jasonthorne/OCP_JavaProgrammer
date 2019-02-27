
//var types: 

let count = 5; //has to now be a number. Cant be changed on fly like js can!
//wont work: count = 'a'; 

let a; //Declared as 'any', and can now be reasigned type without issue:
a = 1;
a = true;
a = 'a';

let b: number; //Declared with a 'type annotation', meaning type has to now remain a number
//wont work: b = true;  b = 'b'; etc


//TypeScript Var types:
let a1: number; //can include any integer or floating point number
let a2: boolean;
let a3: string;
let a4: any;
let a5: number[] = [1,2,3]; //regular array of one var type
let a6: any[] = [1, true, 'a']; //'any' array which can hold multiple var types

