package com.haruo.moco.test.stubs;

import com.github.dreamhead.moco.HttpServer;
import com.github.dreamhead.moco.ResponseHandler;
import com.github.dreamhead.moco.resource.ContentResource;
import com.github.dreamhead.moco.resource.Resource;
import com.github.dreamhead.moco.runner.StandaloneRunner;

import static com.github.dreamhead.moco.Moco.*;
import static com.github.dreamhead.moco.MocoMount.include;
import static com.github.dreamhead.moco.MocoMount.to;

public class MocoStubServer {
    private static HttpServer server;
    private static StandaloneRunner runner;

    public static void main(String[] args) {

        runner = new StandaloneRunner();
        server().mount("web-app/src/main/webapp/javascript", to("/javascript"));
        server().get(by(uri("/"))).response(file("web-app/src/main/webapp/WEB-INF/views/index.html"));
        runner.run(server());
    }

    public static HttpServer server() {
        if (server == null) {
            server = httpserver(8020);
        }
        return server;
    }

    public static void stop() {
        if (runner != null) {
            runner.stop();
        }
    }

    public static void init() {
        runner = new StandaloneRunner();
        server = server();
        server.response(file("web-app/src/main/webapp/WEB-INF/views/index.html"));
        runner.run(server());
    }
}