# 🚌 PCTE Transport — College Bus Route & Timetable Management System

PCTE Transport is a full-stack web application designed for PCTE Group of Institutes to help students and staff track college bus routes, stop schedules, and commute timings through an interactive map interface, while providing an administrative dashboard to manage routes, stop-by-stop timetables, and user accounts.

The project is built using HTML, CSS, JavaScript, Leaflet.js, and Java (Spring Boot) and includes separate student and administrator functionality.

---

## ✨ Features

### 👤 Student & Commuter Features

- **Authentication & Access:** Student sign-up, secure login, and session-aware navigation across portal pages.
- **Interactive Route Map:** Visual map viewer powered by Leaflet.js showing active bus routes, stop marker pins across Ludhiana, and complete route polylines.
- **Bus & Stop Search:** Quickly filter routes by route number, starting point, bus registration number, or intermediate stop names.
- **Structured Bus Timetables:** Route-specific timetable view displaying stop-wise expected arrival times, bus numbers, and morning arrival / evening departure times at the college campus.

### 🛠️ Administrative Features

- **Executive Dashboard:** Central operations panel displaying metric cards for Total Routes, Total Stops, and Total Admins, with quick action shortcuts.
- **Interactive Route Editor:** Map-based route design module to plot stops by clicking the map, draw and redraw route polylines, and save route geometry.
- **Timetable Editor:** Manage bus schedules, configure bus numbers, define arrival/departure timings, and add/edit/remove stop rows dynamically.
- **User & Role Management:** View user directories, create new administrators or users, update profile details, and manage portal access.

---

## 🛠️ Tech Stack

| **Layer** | **Technology** |
|---|---|
| **Frontend** | HTML, CSS, JavaScript |
| **Mapping & UI** | Leaflet.js |
| **Backend** | Java, Spring Boot, REST APIs |
| **Build Tool** | Apache Maven |

---

## 📸 Screenshots
- **Home Portal:** 
<img width="1000" height="500" alt="homepage" src="https://github.com/user-attachments/assets/87ad2b46-d76f-4a7e-a0ef-5424bf972f94" />

- **Route Map Viewer:** 
<img width="1000" height="500" alt="routes" src="https://github.com/user-attachments/assets/af36b2cf-4535-4ade-8b3c-3e72061aeff3" />

- **Bus Timetables:**
<img width="1000" height="500" alt="timetable" src="https://github.com/user-attachments/assets/3d59babf-cdbf-44ea-aed4-0198efffe78a" />

- **Admin Dashboard:**
<img width="1000" height="500" alt="admindashborad" src="https://github.com/user-attachments/assets/d37420b3-a1d0-4868-bb98-e04f53e78cbf" />

- **Route Editor (Leaflet):**
<img width="1000" height="500" alt="add editroute" src="https://github.com/user-attachments/assets/bc77c4d9-e200-420c-bbf6-acfabb67ce4e" />

- **Timetable Editor:**
<img width="1000" height="500" alt="add edit timetable" src="https://github.com/user-attachments/assets/07981624-ef35-4710-97a0-bb07aeea4de6" />


---

## 🎯 Project Objectives

- **Live GPS Tracking:** Hardware GPS unit integration on college buses for real-time live map tracking.
- **Delay & Weather Notifications:** Automated SMS and web push alerts for schedule delays or breakdown alerts.
- **Mobile Web App:** Installable mobile view for quick on-the-go commute lookups.

---

## 🚀 Local Installation & Setup

### Prerequisites

- **Java Development Kit (JDK 17 or higher)**
- **Apache Maven**
- **Modern Web Browser** (Chrome, Firefox, Edge)
- **Git CLI**

### Steps

1. **Clone the repository:**

   ```bash
   git clone https://github.com/kartikthakurx/PCTE-bus-transport-system.git
   ```

2. **Navigate to the backend directory:**

   ```bash
   cd pcte-transport/backend
   ```

3. **Build and run the Spring Boot application:**

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Launch the Application:** Open your browser and navigate to the frontend root or localhost port configured in your server setup (e.g., `http://localhost:8080/` or open `index.html` via VS Code Live Server).

---

## 🔮 Future Enhancements

- **Live GPS Tracking:** Hardware GPS unit integration on college buses for real-time live map tracking.
- **Delay & Weather Notifications:** Automated SMS and web push alerts for schedule delays or breakdown alerts.
- **Mobile Progressive Web App (PWA):** Installable mobile view for quick on-the-go commute lookups.

---

## 👨‍💻 Developer

**Kartik Thakur**

BCA Student | Data Analyst & Full-Stack Developer

**GitHub:** [@kartikthakurx](https://github.com/kartikthakurx)


---

## 📜 License

This project is licensed under the MIT License.

---

## ⭐ Support

If you find this project helpful or well-structured, please consider giving the repository a Star (⭐) on GitHub!
