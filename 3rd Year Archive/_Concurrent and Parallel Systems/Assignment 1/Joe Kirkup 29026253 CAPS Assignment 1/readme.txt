Archive contents:
readme.txt - This document.

TCPClient - Folder containing the solution and executable file for my client / test harness.

TCPServerMultithreaded - Folder containing the solution and executable file for my client / test harness.

Joe Kirkup 29026253 CAPS Assignment Report.pdf - PDF document containing my report as requested in the assignment brief.

ReferenceTCPClient v3.0.exe - I have included the Reference Client as my client / test harness is not functional.
You should use this, with the same instructions as my client, to test my server.



To run the TCPClient.exe located within the folder of the same name:
Open a command prompt and navigate to the folder.
Run the exe file with the following arguments:
- IP address (localhost unless you are running the server on another IP)
- Number of poster threads
- Number of reader threads
- Runtime (in seconds) to generate requests for
- Throttling (1 to throttle the client to 1,000 requests per second, 0 to leave it unthrottled)

To run the TCPServerMultithreaded.exe within the folder of the same name:
Open a command prompt and navigate to the folder.
Run the exe file. No command line arguments are required.

My code consists of two Visual Studio solutions and can be compiled normally using VS Build/Run.