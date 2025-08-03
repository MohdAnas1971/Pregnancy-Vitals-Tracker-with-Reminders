# Pregnancy Vitals Tracker

A simple and helpful Android app built with **Jetpack Compose** that allows expecting mothers to **log and track their vitals** during pregnancy. The app sends periodic reminders every 5 hours to help stay on top of health monitoring.
<br/>
## 📱 Features

- 📋 **Vitals Logging**: Log Blood Pressure (Systolic/Diastolic), Heart Rate, Weight, and Baby Kicks.
- 📊 **Vitals History**: View a list of all previously recorded vitals using a sleek Compose-based UI.
- ⏰ **Reminders**: Get a **notification every 5 hours** to remind you to log vitals.
- 🧠 **MVVM Architecture**: Clean separation of concerns using ViewModel and Repository pattern.
- 🗄️ **Room Database**: All vitals are stored locally for offline access.
- 📡 **Live UI Updates**: Auto-refresh the vitals list with StateFlow.

<br/>

## 🛠️ Tech Stack

| Layer              | Technology             |
|--------------------|------------------------|
| Language           | Kotlin                 |
| UI                 | Jetpack Compose        |
| Architecture       | MVVM                   |
| Database           | Room                   |
| State Management   | StateFlow              |
| Background Task    | WorkManager            |
| Dependency Injection | Hilt Dagger          |

<br/>

## 🧩 Screenshots
<p align="left">
  <img src="https://github.com/user-attachments/assets/459bc82b-8c83-41e1-9d1f-aa0018c919e3" alt="Main Screen" width="250" height="500" />
  &nbsp;&nbsp;&nbsp;
  <img src="https://github.com/user-attachments/assets/2a5edb4b-85a6-46f7-a1d7-8bbe4092fa83" alt="Vitals Dialog" width="250" height="500" />
  &nbsp;&nbsp;&nbsp;
  <img src="https://github.com/user-attachments/assets/98adc74c-da20-4ab9-9f84-d70f2708dce8" alt="Notification" width="250" height="500" />
</p>

<br/>

## 📦 Installation
1.Clone the repository:

```bash
   git clone https://github.com/MohdAnas1971/Pregnancy-Vitals-Tracker-with-Reminders.git
   cd Pregnancy-Vitals-Tracker-with-Reminders
```
2.Open the project in Android Studio.

3.Let Gradle sync and build the project.

4.Run the app on an emulator or physical device.
