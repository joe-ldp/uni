// The text encryption program in C++ and ASM with a very simple example encryption method - it simply adds 1 to the character.
// The encryption method is written in ASM. You will replace this with your allocated version for the assignment.
// In this version parameters are passed via registers (see 'encrypt' for details).
//
// Author: A.Oram (Feb 2018)
// Last revised Feb 2020 by A.Oram

#pragma region Definitions

char EKey = 'x';      // Replace x with your Encryption key.

#define StudentName "Joe Kirkup"

#define MAXCHARS 6    // feel free to alter this, but 6 is the minimum

using namespace std;

#include <string>               // for strings
#include <fstream>              // file I/O
#include <iostream>             // for cin >> and cout <<
#include <iomanip>              // for fancy output
#include "TimeUtils.h"          // for GetTime, GetDate, etc.

#define dollarchar '$'          // string terminator

char OChars[MAXCHARS],          // Original character string
     EChars[MAXCHARS],            // Encrypted character string
     DChars[MAXCHARS] = "Soon!";  // Decrypted character string

#pragma endregion

#pragma region CPPFunctions

void get_char(char& a_character)
{
    a_character = (char)_getwche();
    
    if (a_character == '\r' || a_character == '\n')  // allow the enter key to work as the terminating character too
        a_character = dollarchar;
}

void get_original_chars(int& length)
{
    char next_char = ' ';
    length = 0;
    get_char(next_char);

    while ((length < MAXCHARS) && (next_char != dollarchar))
    {
        OChars[length++] = next_char;
        get_char(next_char);
    }
}

#pragma endregion

#pragma region Encryption

void encrypt_chars (int length, char EKey)
{
    char temp_char;                       // Character temporary store

    for (int i = 0; i < length; i++)      // Encrypt characters one at a time
    {
        temp_char = OChars[i];              // Get the next char from Original Chars array
                                            // Note the lamentable lack of comments below!
        __asm
        {                                     // Start of assembly code
            push   eax                        // Push the values of EAX,
            push   ecx                        // ECX,
            push   edx                        // and EDX onto the stack to save their contents for later

            movzx  ecx, temp_char             // Copy the 'encryptee' char into the ECX register for easy access using movzx to ensure the rest of the register is filled with zeros
            lea    eax, EKey                  // Load the address of the EKey char into the EAX register
            call   encrypt_10                 // Call the encryption function
            mov    temp_char, dl              // Move the last 8 bits (size of a char) from the EDX register containing our encrypted char back into the c++ variable

            pop    edx                        // Pop the values of EDX,
            pop    ecx                        // ECX,
            pop    eax                        // and EAX back off the stack (in reverse order) to retrieve their original contents
        }
        EChars[i] = temp_char; // Store encrypted char in the Encrypted Chars array
    }
    return;


    // Encrypt subroutine. You should paste in the encryption routine you've been allocated from BB and
    // overwrite this initial, simple, version. Ensure you change the ‘call’ above to use the
    // correct 'encrypt_nn' label where nn is your encryption routine number.

    // Inputs: register EAX = 32-bit address of Ekey,
    //                  ECX = the character to be encrypted (in the low 8-bit field, CL).

    // Output: register EDX = the encrypted value of the source character (in the low 8-bit field, DL).
    // REMEMBER TO UPDATE THESE COMMENTS AS YOU DO THE ASSIGNMENT. DELETE OLD/STALE COMMENTS.

    __asm
    {
        encrypt_10:
            push  ecx             // Push the current value of the ECX register (the char we're encrypting) onto the stack, to save it for later
            mov   ecx, [eax]      // Copy the value of EAX into ECX - this is the EKey, as set before this function is called
            and   ecx, 0x000000A7 // Perform a logical AND between ECX and an arbitrary hex value - to mess it up a bit
            rol   cl, 1           // CL refers to the last 8 bits of ECX, this instruction shifts those bits backwards (and loops back around to the front) by one space.
            add   ecx, 0x03       // Add an arbitrary number to the value
            mov   edx, ecx        // Copy the current value of ECX into EDX for now
            pop   ecx             // Grab the original value of ECX back off the stack
            add   ecx, edx        // Add together the encryptee char and the deformed EKey char
            ror   cl, 1           // Similar to rol but the bits are shifted the other way
            ror   cl, 1           // Similar to rol but the bits are shifted the other way
            mov[eax], edx         // Essentially the same as 'mov eax edx', uses the address of eax when it is placed inside the square brackets
            mov   eax, ecx        // Copy the value of ECX into EAX
            add   eax, 0x10       // Add another arbitrary hex value to the contents of EAX
            mov   edx, eax        // Copy EAX into EDX
            ret                   // Return to where the function was called
    }
}

#pragma endregion

#pragma region Decryption

void decrypt_chars (int length, char EKey)
{
  /*** To be written by you ***/

  return;
}

#pragma endregion

#pragma region MainProgram

int main(void)
{
    int char_count (0);  // The number of actual characters entered (upto MAXCHARS limit).
    
    cout << "\nPlease enter upto " << MAXCHARS << " alphanumeric characters:  ";
    
    get_original_chars (char_count);	// Input the original character string to be encrypted 
                                        
    // Open a file to store results (you can view and edit this file in Visual Studio)
    ofstream EDump;

    EDump.open("EncryptDump.txt", ios::app);
    EDump << "\n\nFoCA Encryption program results (" << StudentName << ") Encryption key = '" << EKey << "'";
    EDump << "\nDate: " << GetDate() << "  Time: " << GetTime();

    // Display and save to the EDump file the string just input

    cout  << "\n\nOriginal string =  " << OChars << "\tHex = ";
    EDump << "\n\nOriginal string =  " << OChars << "\tHex = ";


    for (int i = 0; i < char_count; i++)
    {
        cout << hex << setw(2) << setfill('0') << ((int(OChars[i])) & 0xFF) << "  ";
        EDump<< hex << setw(2) << setfill('0') << ((int(OChars[i])) & 0xFF) << "  ";
    };

    // Encrypt the string and display/save the result

    encrypt_chars (char_count, EKey);

    cout  << "\n\nEncrypted string = " << EChars << "\tHex = ";
    EDump << "\n\nEncrypted string = " << EChars << "\tHex = ";

    for (int i = 0; i < char_count; i++)
    {
        cout << ((int(EChars[i])) & 0xFF) << "  ";
        EDump<< ((int(EChars[i])) & 0xFF) << "  ";
    }

    // Decrypt the encrypted string and display/save the result

    decrypt_chars (char_count, EKey);	//**** YOU NEED TO WRITE THE BODY OF THIS FUNCTION ***

    cout  << "\n\nDecrypted string = " << DChars << "\tHex = ";
    EDump << "\n\nDecrypted string = " << DChars << "\tHex = ";

    for (int i = 0; i < char_count; i++)
    {
        cout  << ((int(DChars[i])) & 0xFF) << "  ";
        EDump << ((int(DChars[i])) & 0xFF) << "  ";
    }



    cout  << "\n\n\n";
    EDump << "\n\n-------------------------------------------------------------";
    EDump.close();

    system("PAUSE");
    return (0);
}

#pragma endregion
