require ${PN}.inc

S = "${WORKDIR}/git"
SRCREV = "${AUTOREV}"
SRC_URI = "git://git.osmocom.org/libosmo-sccp.git;protocol=git"
PR = "${INC_PR}.1"

# we require the tests to link to the static libosmo-sigtran library to
# access symbols not starting with osmo_*
EXTRA_OECONF_remove = "--disable-static"

# because "${WORKDIR}/git" is not a git repo, it can't figure out the version
do_configure_prepend() {
    echo "${PV}" > ${S}/.tarball-version
}
