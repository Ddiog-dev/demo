# Phase 1
FROM node:15.6.0 AS build

RUN mkdir /usr/src/app

WORKDIR /usr/src/app

RUN npm install -g @angular/cli

COPY . .


