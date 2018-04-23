#include<stdio.h>

int add(int a, int b);

int main() {

    int a,b;

    printf("Lets call a function from second module\n");

    printf("Enter two numbers : \n");
    scanf("%d %d",&a,&b);

    add(a,b);

   return 0;
}