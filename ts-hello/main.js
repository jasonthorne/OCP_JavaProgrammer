//+++++++++++++++++Typescript 5. VARIABLE TYPES. 
//'let' is important here as it gives proper scope to the variable. ('var' gives global scope instead):
var count = 5; //has to now be a number. Cant be changed on fly like js can!
//wont work: count = 'a'; 
var a; //Declared as 'any', and can now be reasigned type without issue:
a = 1;
a = true;
a = 'a';
var b; //Declared with a 'type annotation', meaning type has to now remain a number
//wont work: b = true;  b = 'b'; etc
//TypeScript Var types:
var a1; //can include any integer or floating point number
var a2;
var a3;
var a4;
var a5 = [1, 2, 3]; //regular array of one var type
var a6 = [1, true, 'a']; //'any' array which can hold multiple var types
var colour;
(function (colour) {
    colour[colour["Red"] = 0] = "Red";
    colour[colour["Green"] = 1] = "Green";
    colour[colour["Blue"] = 3] = "Blue";
})(colour || (colour = {}));
; //explicently setting the values by index (red=0) protects against potential issues if other elements are added. (Apparently! :D)
var backgroundColour = colour.Red;
//+++++++++++++++++ Typescript 6. TYPE ASSERTIONS.
var message = 'abc'; //initially declared as string
var endsWithc = message.endsWith('c'); //acess granted to string methods as initially declared as string
var message2; //initially declared as any
message2 = 'def'; //then made a string
var endsWithf = message2.endsWith('f'); //needs cast like this to then provide access to string methods!
var alsoEndsWithf = message2.endsWith('f'); //another way of doing it
console.log("Boolean results: " + endsWithc, endsWithf, alsoEndsWithf);
//+++++++++++++++++Typescript 7. ARROW FUNCTIONS (lambda). 
//regular function:
var regularFunction = function (myMessage) {
    console.log(myMessage);
};
//trpescript arrow function:
var arrowFunction = function (myMessage) { return console.log(myMessage); }; //can exclude braces due to code only being one line 
regularFunction("Yo");
arrowFunction("dawg!");
//+++++++++++++++++Typescript 8. INTERFACES.  
///create drawPoint method:
var drawPoint = function (myPointObj) {
    //..
};
//calling drawPoint method and passing two properties (BAD as this allows passing of any property type!!)
drawPoint({
    x: 1,
    y: 2
});
//BETTER SOLUTION is to annotate the drawPoint method's input perameters. (called 'inline annotation'):
var drawPoint2 = function (myPointObj) {
    //..
};
//then create method, with input perameter of type 'Point'
var drawPoint3 = function (myPointObj) {
    //...
};
//+++++++++++++++++Typescript 9. CLASSES.
//Classes group variables (properties) and functions (methods) that are highly related
var ExampleClass = /** @class */ (function () {
    function ExampleClass() {
    }
    //method (a function within a class)
    ExampleClass.prototype.exampleMethod = function () {
        console.log("X: " + this.x + " Y: " + this.y); //'this' is needed here for reference. (cant just use 'x'!)
    };
    //method
    ExampleClass.prototype.exampleMethod2 = function (exampleObj) {
    };
    return ExampleClass;
}());
//+++++++++++++++++Typescript 10. OBJECTS.  
//declare a var of class type:
var exampleObj2 = new ExampleClass(); //No annotation needed as will be infered. Unnecessary annotation example:- let exampleObj: ExampleClass = new ExampleClass();
exampleObj2.x = 1;
exampleObj2.y = 2;
exampleObj2.exampleMethod(); //call object's method 
//+++++++++++++++++Typescript 11. CONSTRUCTORS. 
var MyClass = /** @class */ (function () {
    //Constructor. IMPORTANT: declared with this keyword, NOT class name like Java!! And can only have ONE constructor. Use '?' to allow for optional parameters
    function MyClass(num1, num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    MyClass.prototype.draw = function () {
        console.log("num1: " + this.num1 + " num2: " + this.num2);
    };
    return MyClass;
}());
var myObj = new MyClass(1, 2); //Input parameters are needed here, as there is NO default constructor
myObj.draw();
