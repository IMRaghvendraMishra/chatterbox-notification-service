# ChatterBox - Notification Service

**Service Role:**  
The Notification Service is responsible for simulating alerts or notifications when users create new posts or follow others in the ChatterBox platform. This mock implementation logs or stores messages in memory rather than integrating with a real notification provider.

---

## 🚀 Features

- Accepts notification events via a REST API.
- Retrieves past notifications (stored in-memory).
- Lightweight and stateless design for easy testing and simulation.

---

## 📦 API Endpoints

### `POST /notifications`
Send a new notification event.

**Request Body:**
```json
{
  "userId": "123",
  "message": "You have a new follower!"
}
