#include "iostream"

int main(void)	// Minimal C++ harness
{
	int x;	// declaration of variable 'x' and
	char key;	// single byte variable called 'key'

	__asm
	{		// start of assembly code section
		mov		x, 00	// clear 'x' to zero
		mov		key, '$' 	// put dollar sign in 'key'
		mov		ebx, dword ptr[key]	// move '$' into register EBX
		xor		eax, eax	// clear reg EAX to zero using XOR
		add		eax, 1	// add 1 to EAX
		mov		x, eax	// store EAX's data in variable 'x'
	}	// end of assembly code

	return (0);	// C++ again
}