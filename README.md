# QRcode Attendance App

## Overview

QRcode Attendance App is an Android application developed using Android Studio that enables efficient attendance management through QR code scanning. The app utilizes the ZXing library for QR code generation and scanning and integrates Firebase for backend support to store and manage attendance records.

## Features

- **QR Code Generation**: Create unique QR codes for each user.
- **QR Code Scanning**: Scan QR codes to mark attendance.
- **Firebase Integration**: Store and manage attendance records in real-time using Firebase.
- **User Authentication**: Secure login and registration system using Firebase Authentication.
- **Real-Time Data**: Real-time updates and synchronization of attendance records.

## Installation

1. **Clone the Repository**

   ```bash
   git clone https://github.com/yourusername/QRcode_Attendance_App.git
   cd QRcode_Attendance_App
   ```

2. **Open in Android Studio**

   - Open Android Studio.
   - Select `File > Open` and navigate to the cloned repository.
   - Wait for the project to sync and build.

3. **Configure Firebase**

   - Go to the [Firebase Console](https://console.firebase.google.com/).
   - Create a new project or use an existing project.
   - Add an Android app to your Firebase project.
   - Follow the instructions to download the `google-services.json` file.
   - Place the `google-services.json` file in the `app` directory of your project.

4. **Add Dependencies**

   Ensure that the following dependencies are added in your `build.gradle` (app-level) file:

   ```groovy
   dependencies {
       implementation 'com.google.firebase:firebase-auth:19.3.2'
       implementation 'com.google.firebase:firebase-database:19.3.1'
       implementation 'com.google.firebase:firebase-storage:19.1.1'
       implementation 'com.journeyapps:zxing-android-embedded:4.1.0'
       implementation 'com.google.zxing:core:3.4.1'
   }
   ```

5. **Sync and Build the Project**

   - Click on `Sync Now` in the notification bar or go to `File > Sync Project with Gradle Files`.

6. **Run the App**

   - Connect your Android device or start an emulator.
   - Click on the `Run` button in Android Studio or press `Shift + F10`.

## Usage

1. **User Registration and Login**

   - Users can register using their email and password.
   - After registration, users can log in with their credentials.

2. **QR Code Generation**

   - Once logged in, users can generate their unique QR code from the dashboard.

3. **QR Code Scanning**

   - Users can scan the QR code using the built-in scanner to mark their attendance.
   - Attendance data is automatically updated and stored in Firebase.

4. **View Attendance Records**

   - Users and admins can view attendance records in real-time.
   - Attendance data is synced with Firebase and can be accessed anytime.

## Contributing

1. **Fork the Repository**

   - Click on the `Fork` button on the repository's GitHub page.

2. **Create a New Branch**

   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Changes and Commit**

   ```bash
   git commit -m "Add your feature"
   ```

4. **Push to the Branch**

   ```bash
   git push origin feature/your-feature-name
   ```

5. **Open a Pull Request**

   - Go to the repository on GitHub and click on `Pull Requests`.
   - Click on `New Pull Request` and follow the instructions.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [ZXing Library](https://github.com/zxing/zxing)
- [Firebase](https://firebase.google.com/)

## Contact

If you have any questions, feel free to reach out at [jayeshinamdar316@gmail.com].

---

Thank you for using QRcode Attendance App!
