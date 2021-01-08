FROM node:12-alpine
WORKDIR /demo
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]