var name = "Samu";
var handle = "samumoil";
var country = "Finland";

function whoAmI(name,handle,country) {
    console.log(`
    Hi, my name is ${name}, my GitHub handle is ${handle} and I'm from ${country}.
    `);
}

whoAmI(name,handle,country);

var test1 = !false;
var test2 = !false;
var number = 3;

number++;
console.log(number)
number += 10;
console.log(number)

console.log( number );


var students = ["yksi", "kaksi", "kolme", "neljä", "viisi"];

console.log(students);

for (let i = 0; i < students.length; i++) {
    console.log("hei", students[i]);
}

for (let i of students) {
    console.log("hei", i)
}

