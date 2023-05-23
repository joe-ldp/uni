#include "CommandList.h"
#include <fstream>
#include "CmdGoto.h"
#include "CmdForward.h"
#include "CmdRotate.h"

using namespace std;

CommandList::CommandList(const wchar_t* filename)
{
	root = new CmdGoto(nullptr, 0, 0);
	TurtleCommand *current = root;

	ifstream fin(filename, ios::in);

	if (fin)
	{
		string command;
		fin >> command;

		while (!fin.eof())
		{
			if (command == "Goto")
			{
				current = new CmdGoto(current, fin);
			}
			else if (command == "Forward")
			{
				current = new CmdForward(current, fin);
			}
			else if (command == "Rotate")
			{
				current = new CmdRotate(current, fin);
			}

			fin >> command;
		}

		fin.close();
	}
}