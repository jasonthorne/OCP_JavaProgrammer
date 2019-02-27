
//+++++++++++++++++Typescript 5. VARIABLE TYPES. 

//'let' is important here as it gives proper scope to the variable. ('var' gives global scope instead):
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

enum colour {Red = 0, Green = 1, Blue = 3}; //explicently setting the values by index (red=0) protects against potential issues if other elements are added. (Apparently! :D)
let backgroundColour = colour.Red;



//+++++++++++++++++ Typescript 6. TYPE ASSERTIONS.

let message = 'abc'; //initially declared as string
let endsWithc = message.endsWith('c'); //acess granted to string methods as initially declared as string

let message2; //initially declared as any
message2 = 'def'; //then made a string
let endsWithf = (<string>message2).endsWith('f'); //needs cast like this to then provide access to string methods!
let alsoEndsWithf = (message2 as string).endsWith('f'); //another way of doing it

console.log("Boolean results: " + endsWithc, endsWithf, alsoEndsWithf);

//+++++++++++++++++Typescript 7. ARROW FUNCTIONS (lambda). 

//regular function:
let regularFunction = function(myMessage){
    console.log(myMessage);
}

//trpescript arrow function:
let arrowFunction = (myMessage) => console.log(myMessage); //can exclude braces due to code only being one line 

regularFunction("Yo");
arrowFunction("dawg!");

//+++++++++++++++++Typescript 8. INTERFACES.  

///create drawPoint method:
let drawPoint = (myPointObj) => {
    //..
}

//calling drawPoint method and passing two properties (BAD as this allows passing of any property type!!)
drawPoint({
    x: 1,
    y: 2
}) 

//BETTER SOLUTION is to annotate the drawPoint method's input perameters. (called 'inline annotation'):
let drawPoint2 = (myPointObj: {x: number, y: number}) => {
    //..
}

//EVEN BETTER SOLUTION is to use an interface! 

//define interface:
interface Point{
    x: number,
    y: number
}

//then create method, with input perameter of type 'Point'
let drawPoint3 = (myPointObj: Point) => {
    //...
}  

//+++++++++++++++++Typescript 9. CLASSES.

//Classes group variables (properties) and functions (methods) that are highly related

class ExampleClass {
    x: number; //instance var
    y: number;  //instance var

    //method (a function within a class)
    exampleMethod(){
       console.log("X: " + this.x + " Y: " + this.y); //'this' is needed here for reference. (cant just use 'x'!)
    }

    //method
    exampleMethod2(exampleObj: ExampleClass){ //defining input type as an ExampleClass object

    }
}

//+++++++++++++++++Typescript 10. OBJECTS.  

//declare a var of class type:
let exampleObj2 = new ExampleClass(); //No annotation needed as will be infered. Unnecessary annotation example:- let exampleObj: ExampleClass = new ExampleClass();
exampleObj2.x = 1;
exampleObj2.y = 2;
exampleObj2.exampleMethod(); //call object's method 

//+++++++++++++++++Typescript 11. CONSTRUCTORS. 






