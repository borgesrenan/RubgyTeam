/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author renan
 */
public enum StaffType {
    GROUND_STAFF(1) {
        @Override
        public String getName() {
            return "GROUND STAFF";
        }

        @Override
        public Sector getSector() {
            return Sector.CLUB;
        }
    },
    MEDICAL_STAFF(2) {
        @Override
        public String getName() {
            return "MEDICAL STAFF";
        }

        @Override
        public Sector getSector() {
            return Sector.CLUB;
        }
    },
    STRENGTH_CONDITIONING(3) {
        @Override
        public String getName() {
            return "STRENGTH & CONDITIONING";
        }

        @Override
        public Sector getSector() {
            return Sector.COACHING;
        }
    },
    HEAD_COACH(4) {
        @Override
        public boolean isCoachHead() {
            return true;
        }

        @Override
        public Sector getSector() {
            return Sector.COACHING;
        }

        @Override
        public String getName() {
            return "HEAD COACH";
        }
    },
    ASSISTANT_COACH(5) {
        @Override
        public String getName() {
            return "ASSISTANT COACH";
        }

        @Override
        public Sector getSector() {
            return Sector.COACHING;
        }
    },
    SWIM_TEACHER(6) {
        @Override
        public String getName() {
            return "SWIN TEACHER";
        }

        @Override
        public Sector getSector() {
            return Sector.COACHING;
        }
    },
    NUTRITIONIST(7) {
        @Override
        public String getName() {
            return "NUTRITIONIST";
        }

        @Override
        public Sector getSector() {
            return Sector.CLUB;
        }
    },
    PHYSIOTHERAPIST(8) {
        @Override
        public String getName() {
            return "PHYSIOTHERAPIST";
        }

        @Override
        public Sector getSector() {
            return Sector.CLUB;
        }
    };

    private final int id;

    StaffType(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean isEquals(int id) {
        return this.id == id;
    }

    public abstract String getName();

    public abstract Sector getSector();

    public boolean isCoachHead() {
        return false;
    }

    public static List<StaffType> listBySector(Sector sector) {
        List<StaffType> filteredTypes = new ArrayList<>();
        for (StaffType type : values()) {
            if (!type.isCoachHead() && type.getSector() == sector) {
                filteredTypes.add(type);
            }
        }
        return filteredTypes;
    }
}
