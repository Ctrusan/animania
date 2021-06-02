import http from "../http-common";

class AnimaniaService {
  getAll() {
    return http.get("/animania");
  }

  get(id) {
    return http.get(`/animania/${id}`);
  }

  create(data) {
    return http.post("/animania", data);
  }

  update(id, data) {
    return http.put(`/animania/${id}`, data);
  }

  delete(id) {
    return http.delete(`/animania/${id}`);
  }
}
export default new AnimaniaService();