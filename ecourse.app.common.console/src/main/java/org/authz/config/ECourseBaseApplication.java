package org.authz.config;

public abstract class ECourseBaseApplication {
    /**
     * Make all methods implement run that will execute configure and doMain.
     * @param args
     */
    public void run(final String[] args) {
        configure();

        doMain(args);

        System.exit(0);
    }

    /**
     * Execute configuration of authentication.
     */
    protected void configure() {
        configureAuthz();
    }

    /**
     * Start module.
     * @param args
     */
    protected abstract void doMain(String[] args);

    /**
     * Put all necessary configurations about Authz running.
     * For example get dynamically PersistenceContext.
     */
    protected abstract void configureAuthz();
}
