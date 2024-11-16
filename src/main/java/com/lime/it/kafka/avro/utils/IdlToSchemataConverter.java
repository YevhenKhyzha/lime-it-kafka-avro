package com.lime.it.kafka.avro.utils;

import org.apache.avro.tool.IdlToSchemataTool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IdlToSchemataConverter {

    public static void main(String[] args) throws Exception {
        IdlToSchemataTool idlToSchemataTool = new IdlToSchemataTool();

        File inDirectory = new File(args[0]);
        File outDirectory = new File(args[1]);

        File[] inDirectoryFiles = inDirectory.listFiles();

        if (inDirectoryFiles != null && Arrays.stream(inDirectoryFiles).findAny().isPresent()) {
            for (File inputFile : inDirectoryFiles) {
                List<String> idlToSchemataToolArgs = new ArrayList<>();

                idlToSchemataToolArgs.add(inputFile.getAbsolutePath());
                idlToSchemataToolArgs.add(outDirectory.getAbsolutePath());

                int exitCode = idlToSchemataTool.run(System.in, System.out, System.err, idlToSchemataToolArgs);

                if (exitCode != 0) {
                    System.exit(exitCode);
                }
            }
        }
    }
}
