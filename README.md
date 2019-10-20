
Convention
The Jtarget project has built-in Tomcat plug-in, which can be released through any ide tool software in the environment with JDK1.8 or above. Or, if necessary, the jtarget project can be packaged into a war package and deployed on the server through Tomcat software. The following example is to publish Jtarget project under Windows 10 system.

1 installation
	1.1Configure Java environment above JDK1.8

		1.1.1 First, we need to download the java development kit JDK at http://www.oracle.com/technetwork/java/javase/downloads/index.html.

		1.1.2 In the download page, you need to choose to accept the license and choose the corresponding version according to your own system. This paper takes the window 64 bit system as an example.

		1.1.3 Install JDK. During the installation process, you can customize the installation directory and other information. For example, we choose the installation directory as
 		C: \ program files (x86) \ Java \ jdk1.8.0_91

		1.1.4 In Windows 10 press Windows key + Pause Key, This will open the System Settings window. Go to Change settings and select the Advanced tab.

		1.1.5 In“System Properties window”click“Environment Variables…”

		1.1.6 Under “System variables” click the “New…” button and enter JAVA_HOME as “Variable name” and the path to your Java JDK directory under “Variable value”

		1.1.7 In  “Environment Variables” window under “System variables” select Path
			Click on “Edit…”
			In “Edit environment variable” window click “New”
	 		Type in  %JAVA_HOME%\bin

		1.1.8 Open a new command prompt and type in: java -version
		this will print out the version of the java compiler if the Path variable is set correctly or “javac is not recognized as an internal or external command…” otherwise

	1.2 Install IDE software, for example, IntelliJ

		1.2.1 Download the installer at 	https://www.jetbrains.com/idea/download/#section=windows

		1.2.2 Run the installer and follow the wizard steps.

	1.3 Install gradle and configure the enviroment
		
		1.3.1  Download the latest Gradle distribution at https://gradle.org/releases/

		1.3.2 Create a new directory C:\Gradle with File Explorer.

		1.3.3 Open a second File Explorer window and go to the directory where the Gradle distribution was downloaded. Double-click the ZIP archive to expose the content. Drag the content folder gradle-5.6.3 to your newly 			created C:\Gradle folder.
		
		1.3.4 In File Explorer right-click on the This PC (or Computer) icon, then click Properties -> Advanced System Settings -> Environmental Variables.

		1.3.5 Under System Variables select Path, then click Edit. Add an entry for C:\Gradle\gradle-5.6.3\bin. Click OK to save.

		1.3.6 Open a console (or a Windows command prompt) and run gradle -v to run gradle and display the version

	1.4 Install MySQL database
		
		1.4.1 Choose version 5.5 and follow the steps at this page https://dev.mysql.com/doc/mysql-installation-excerpt/5.5/en/windows-install-archive.html

		1.4.2 Don't forget the username and password which is indispensable for the project

2. Running instruction

	2.1 Download the project from GitHub, the url is in section 4
	
	2.2 Create table structure in database

		2.1.1 Open the MySQL in command

		2.1.2 Enter the Src / main / resources / SQL / DDL directory of the project, open and execute sql sentence in MySQL command seperately
		01_database.sql
		02_jtarget_job.sql
		03_jtarget_user.sql
		04_jtarget_apply.sql

	2.3 Running project

		2.3.1 Open IntelliJ, click Import project

		2.3.2 Select the build.gradle file in the jtarget directory and click OK.

		2.3.3 Follow the steps to open the project. This may take some time to download the jar package

		2.3.4 Double click the application.properties file in the src / main / resources directory

		2.3.5 Change the spring.datasource.url(if the port of MySQL is changed or the table name changed) & spring.datasource.username & spring.datasource.password value according to your own configuration 
		
		2.3.6 Double click the jtargetapplication class in the src / main / Java / COM / wattermelon / jtarget directory

		2.3.7 Right click and click Run jtargetapplication

		2.3.8 Open any browser and enter localhost / login in the address bar.

		2.3.9 Or under the same LAN, enter the local IP address / login in another computer.

3. Change log
	
	3.1 If port 80 is occupied, you can modify the port value in the application.properties file in the Src / main / resources directory.

	3.2 If you need to change the database information, such as switching the database, you can follow step 2.2.5

4. GitHub URL
	
	4.1 https://github.com/ZEYINGXU/JTarget.git
