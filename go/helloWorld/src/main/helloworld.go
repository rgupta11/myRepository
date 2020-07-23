package main

import (
	"fmt"
	"os"
)

var s, sep string

func main() {

	fmt.Printf("%s %d %s", "Args len:", len(os.Args), "\n")
	fmt.Printf("%s %s", "Cmd args:", os.Args)

	for i := 0; i < len(os.Args); i++ {
		s += sep + os.Args[i]
		sep = " "
	}
	fmt.Printf("%s %s %s", "for len eg:", s, "\n")
	//fmt.Println(s)
	for _, arg := range os.Args[1:] {
		s += sep + arg
		sep = " "
	}
	fmt.Printf("%s %s %s", "for Range eg:", s, "\n")
	//fmt.Println(s)

	a := 1
	b := 2
	fmt.Printf("%s %d %s", "Sum: ", a+b, "\n")


}
