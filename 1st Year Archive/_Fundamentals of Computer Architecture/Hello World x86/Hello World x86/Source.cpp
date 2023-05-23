#include <iostream>

int main()
{
	char HWtext[] = "Hello World\n";

	__asm
	{
		mov ecx, 10

Lj:		push	ecx
		lea		eax, HWtext
		push	eax
		call	dword ptr printf
		add		esp, 4
		pop		ecx
		sub		ecx, 1
		jnz		Lj
	}

	//system("pause");
	return 0;
}