const user = { name: 'clare', age: 20 }
const user2 = user;
// console.log(user);
user2.name = 'coder';
console.log(user)

//복사1
const user3 = {};
for (key in user) {
    user3[key] = user[key];
}
user3.name = 'developer';
console.log(user3);

//복사 2  
// assign위에서 Ctrl + 클릭 -> assign 사용법 확인
// const user4 = {};
// Object.assign(user4, user);
const user4 = Object.assign({}, user)
user4.name = 'team';
console.log(user4);
// console.log(user);


// 두 개 넣어보기 
// Object.assign(desc, [obj1, obj2, obj3....])
const fruit1 = { color: 'red' };
const fruit2 = { color: 'blue', size: 'big' };

const mixed = Object.assign({}, fruit1, fruit2); // 같은 값은 뒤에서 앞으로 덮어씀
console.log(mixed.color);
console.log(mixed.size);