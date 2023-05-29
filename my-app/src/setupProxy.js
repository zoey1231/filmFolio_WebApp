const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    "/api",
    createProxyMiddleware({
      // target: "https://filmfolio-f39fe.uc.r.appspot.com",
      // target: "http://localhost:8080",
      target: "https://filmfolio-f39fe.uc.r.appspot.com",
      changeOrigin: true,
    })
  );
};
