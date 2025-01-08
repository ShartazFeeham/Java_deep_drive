### [IntegerStoring](IntegerStoring.java)
- Integers from 0-127 are not stored in Integer class objects
- That's why x == y is true as the actual values are compared
- But p == q is stored in the heap as Integer class instances so p and q are not values but references
- That's why p == q is false
```
OUTPUT

true
false
```

[Special.java](Special.java)
- For the first part, it's just too much!
- For the second part, we can use any number of underscores, but nor in the beginning/end of the number neither before/after a decimal point