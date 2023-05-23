//#include <iostream>
//#include <thread>
//#include <string>
//#include <vector>
//#include <sstream>
//
//void print(std::string str)
//{
//	int i;
//
//	for (i = 0; i < 10; i++)
//	{
//		std::cout << str;
//		std::this_thread::sleep_for(std::chrono::milliseconds(50));
//	}
//}
//
//int main()
//{
//	int nthreads;
//	int id;
//	
//	std::vector<std::thread> threadHandles;
//
//	std::stringstream sstr;
//
//	std::cout << "How many threads to spawn? ";
//	std::cin >> nthreads;
//
//	for (id = 0; id < nthreads; id++)
//	{
//		sstr.clear();
//		sstr << id;
//
//		threadHandles.emplace_back(print, sstr.str());
//	}
//
//	for (id = 0; id < nthreads; id++)
//	{
//		threadHandles[id].join();
//	}
//
//	return 0;
//}