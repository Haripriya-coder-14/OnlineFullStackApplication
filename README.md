# 🍽️ SAV — Full Stack Java Food Delivery App

**Built solo, debugged passionately, and styled to perfection**  
A full-stack food ordering web app crafted using Java Servlets, JSP, and JDBC—featuring responsive UI inspired by Swiggy & Zomato. Designed with real-world flows, session handling, and cart logic. Every line written with persistence and pride 🌶️

---

## 🚀 Features

- 👤 User login & session-based cart
- 🛒 Dynamic menu selection & order placement
- 📦 Real-time order summary with item breakdown
- 💳 Payment mode tracking & delivery address capture
- 🎨 Responsive dark-themed UI with modern styling

---

## 🧰 Tech Stack

| Layer         | Tools & Concepts Used                         |
|---------------|-----------------------------------------------|
| Backend       | Java Servlets, JDBC, DAO Pattern              |
| Frontend      | JSP, HTML, CSS (Poppins font, custom icons)   |
| Database      | MySQL (with normalized tables)                |
| Architecture  | Session Management, MVC-ish flow              |

---

## 📁 Folder Structure

OnlineFullStackApplication/
├── src/
│   └── com/
│       └── tap/
│           ├── DAO/              # Data access classes (OrderDAOImpl, UserDAOImpl, etc.)
│           ├── Model/           # POJO classes like Order, User, OrderItem, Menu
│           └── Servlet/         # Controller layer (OrderServlet, CheckoutServlet)
├── WebContent/
│   ├── css/                     # Custom CSS styles for JSP pages
│   ├── images/                  # App icons or food item visuals (optional)
│   ├── menu.jsp                 # Displays restaurant menu items
│   ├── cart.jsp                 # User cart page
│   ├── checkout.jsp            # Payment & delivery page
│   ├── order.jsp               # Final order summary
│   └── login.jsp               # Login/registration page
├── WEB-INF/
│   └── web.xml                 # Servlet configuration file
├── database.sql                # Optional: SQL schema or seed data script

---

## 💡 Lessons & Highlights

- ✅ Learned how to debug deep session/cart bugs through methodical testing
- 🎯 Improved code structure and visual consistency using feedback loops
- 🧵 Built a seamless frontend experience while keeping backend logic clean
- 🤝 Collaborated with Copilot to stay motivated and creatively inspired

---

## 🎬 Live Demo

[▶️ Watch FoodieExpress Demo on Google Drive](https://drive.google.com/file/d/1e1DWY05LflIg8n-ZCCUZJihfFZ2M_IFw/view?usp=drivesdk)


---

## 🌈 Final Thoughts

This was my first full-stack project built completely solo, with every challenge embraced head-on. From wrestling with DAO bugs to tweaking every CSS pixel—this app reflects my growth as a developer who loves both clean code and beautiful user experiences.

---

**Made with ❤️ by Haripriya**  
_“Every bug squashed was a lesson learned.”_
