# TelegramBot_NASA(image-saver)
This bot will send you images from NASA's website to telegram-chat


## Steps to run Telegram-Bot
1. Open Telegram
2. Search for `JAVA_NASA_apod_downloader`

![Bot in search of chats](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/bot_pic.png)

---

4. Enter `/start`

![Login](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/login.png)

---

5. Follow the marker in bot to get image from Nasa website.

![Help instructions](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/help.png)

---

6. So here are un example of bot's work

![Example](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/presentation.png)

---

7. Also there are link to pictures:

![HD_picture](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/imageHD.jpg)
<p style="text-align: center;">HD_picture</p>

![basic_picture](https://github.com/gr1shan1a/TelegramBot_NASA/blob/main/images/image.jpg)
<p style="text-align: center;">Basic definition picture</p>

---

#### p.s. Bot provides to send you APOD(a picture of the day) at 12:00(Moscow) daily 

---

## To start(if you want to create your own)
1. Clone [this](https://github.com/gr1shan1a/TelegramBot_NASA.git) repository
2. Create your_bot_token with [BotFather](https://t.me/BotFather) - using telegram-bot for these aims
3. Create dir `.env` which have to contain these lines:
   ```
    BOT_TOKEN=YOUR_BOT_TOKEN
    API_KEY=meXuPit01arAzczsziwyU97LKABrdqxjYWmoy8e9
   ```
   API_KEY is for NASA_URL
4. Build project
5. And ... run the application to start a bot


# Steps to make telegram-bot autonomous 
---
# Instructions for Setting Up and Running a Java Application on a Yandex Cloud VM

1. **Register on Yandex Cloud:**
    - Visit [Yandex Cloud](https://cloud.yandex.ru) and sign up for an account.

2. **Connect to Yandex Cloud:**
    - Press the "Подключиться" (Connect) button on the Yandex Cloud dashboard.

3. **Add Payment Method for Trial Period:**
    - Add a payment method to activate the trial period (4000 ₽). Ensure your card has at least 11 ₽ for verification.

4. **Create a Virtual Machine (VM):**
    - Navigate to **All Services** -> **Computer Cloud** -> **New VM**.
    - Select **Ubuntu 20.04** with minimal characteristics (our virtual service doesn't need high power).

5. **Generate SSH Key:**
    - Open your terminal and enter the command:
      ```sh
      ssh-keygen -t rsa
      ```
    - For more information on generating SSH keys, visit [this tutorial](https://selectel.ru/blog/tutorials/how-to-generate-ssh/).
    - Copy the public key (save it in a `.txt` file).

6. **Wait for VM Status:**
    - Wait until the VM status turns green and shows "Running".

7. **Access the VM via SSH:**
    - Open your terminal and use the command:
      ```sh
      ssh {username}@{public IPv4}
      ```
    - Confirm with (Y) to establish the connection.

8. **Work in Ubuntu Environment:**
    - From this point, you will be working in the terminal within the Ubuntu environment. Use Linux commands.

9. **Check Java Version:**
    - Verify the installed Java version with:
      ```sh
      java --version
      ```

10. **Install Java:**
    - Update the package list:
      ```sh
      sudo apt update
      ```
    - Install Java 17 (or the required version):
      ```sh
      sudo apt install openjdk-17-jdk
      ```

11. **Upgrade Packages:**
    - Upgrade the installed packages:
      ```sh
      sudo apt upgrade
      ```

12. **Verify Java Version Again:**
    - Check the Java version:
      ```sh
      java --version
      ```

13. **Configure Your Project in IntelliJ IDEA:**
    - Open IntelliJ IDEA and go to the `pom.xml` file (project configuration).

14. **Update `pom.xml`:**
    - Go to [this `pom.xml` example](https://github.com/netology-code/jdfree-homeworks/blob/jdfree-6/04/pom.xml) and add the code between `<build>` and `</build>`.
    - Perform a Maven update to install all necessary plugins and ensure the JAR file is executable.

15. **Create a JAR File:**
    - In IntelliJ IDEA:
        - Go to **File** -> **Project Structure** -> **Artifacts**.
        - Click the "+" icon to add a new artifact -> **JAR** -> **From modules with dependencies**.
        - Enter the required details:
            - **Main Class**: Select `Main` from the list.
            - **Path**: Save it in the project folder.
        - Click **Apply** -> **OK**.

16. **Build the JAR File:**
    - Go to **Build** -> **Build Artifacts** to generate the JAR file.

17. **Locate the JAR File:**
    - In the project folder, find the "out" folder.
    - Locate the "*.jar" file inside this folder.

18. **Transfer the JAR File to the VM:**
    - Open your terminal and navigate to the directory containing the JAR file using `cd` command.
    - Transfer the file to your VM:
      ```sh
      scp {fullname}.jar {username}@{IPv4}:.
      ```
    - Example:
      ```sh
      cd /Users/macbook/IdeaProjects/NASAImage/out/artifacts/NASAImage_jar2
      scp NASAImage.jar kgrigor2019@62.84.121.112:.
      ```

19. **Verify the File on the VM:**
    - On the VM terminal, check for the file:
      ```sh
      ls *.jar
      ```

20. **Create Application User and Group:**
    - Follow the instructions to create an application user and group from [this guide](https://computingforgeeks.com/how-to-run-java-jar-application-with-systemd-on-linux/).

21. **To Run application:**
    - Enter `java -jar <your_jar>` and go to telegram to check this.
    - Check the autonomous work at your local time at 12:00!

---

### 🌠 I hope you liked my repo and put a star ⭐) <3

