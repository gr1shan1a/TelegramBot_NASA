# TelegramBot_images_NASA1
This bot will send you images from NASA's website

## Steps to run Bot
1. Open Telegram
2. Search for `JAVA_NASA_apod_downloader`
3. Enter `/start`
4. There are several buttons, so follow the commands below:
   - `/get` - means to upload APOD(a picture of the day) to the chat
   - TODO: Add commands 
6. 

# Steps to make telegram-bot autonomous 
---
1) Register on https://cloud.yandex.ru
2) Press "подключиться"
![сайт yandex.cloud](https://github.com/gr1shan1a/TelegramBot_images_NASA1/raw/main/Users/macbook/Documents/GitHub/TelegramBot_images_NASA1/screanshot.png)
3) Add your payment method for getting trial period(4000₽) - you need to confirm your card payment-able: 11 rubles must be on it
4) Then make VM: all versives -> computer cloud -> new VM -> Ubuntu 20.04 -> minimal characteristics(our virtual service doesn't need big powers)
5) Get ssh: go to terminal and enter command: ssh-keygen -t rsa
<br/> For more information go to https://selectel.ru/blog/tutorials/how-to-generate-ssh/ -> then copy public key(use .txt - file)
6) Wait until the status of this VM become green and "running"
7) Go to terminal
8) enter command: shh {username}@{public IPv4}, then confirm(Y)
9) From this moment we work in terminal in Ubuntu environment, therefore we should you linux commands
10) Checking java version:   java --version
11) To install: sudo apt update + take 17th version java from the previous step
12) Then sudo apt upgrade
13) Check version also: java --version
14) Ok, our cloud environment is installed completely -> go to IDE
I use InteliJ Idea
15) So, go to pom.xml(file, where we can make setting of our project)
16) Go to https://github.com/netology-code/jdfree-homeworks/blob/jdfree-6/04/pom.xml and add the part of code between <build>some_code</build> -> maven update to install all plugins for autononomous work(чтобы jar-ник был исполняемым)
17) Make Jar-file:
<br/> To make JAR in InteliJ Idea: go to File -> Project Structure -> Artifacts -> "+" to add new -> Jar -> From modules with dependencies -> Enter -> Select Main Class: Main(from list) -> path: save it in the project-folder -> apply -> ok
<br/> (All this need to male a manifest to mark the entering point of a jar-file)
18) Go build -> build Artifacts
19) On the left in project-folders find orange-folder "out" -> open it and find "*.jar"
20) Open it in terminal OR open terminal and using cd-command -> go to this folder
21) After this part(path) -> [ scp {fullname}](, fullname.jar: example: NASAImage.jar) + [{username}@{IPv4}:.]
like: "cd /Users/macbook/IdeaProjects/NASAImage/out/artifacts/NASAImage_jar2\ scp NASAImage.jar kgrigor2019@62.84.121.112:." - перенести данный файл и кинуть в корень
22) Then we go to VM(in terminal) and use: ls    *.jar - file in VM(isRed)
23) Creating an Application User and group: https://computingforgeeks.com/how-to-run-java-jar-application-with-systemd-on-linux/
24) Do all commands from the step above
